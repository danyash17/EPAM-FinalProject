package com.epam.web.connection;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static final AtomicReference<ConnectionPool> INSTANCE = new AtomicReference<>();

    private static final Lock INSTANCE_LOCK = new ReentrantLock();

    private final Queue<ProxyConnection> availableConnections = new ArrayDeque<>();
    private final Set<ProxyConnection> activeConnections = new HashSet<>();

    private final Lock LOCK = new ReentrantLock();
    private final Semaphore connectionsSemaphore;

    public static ConnectionPool getInstance() {

        if (INSTANCE.get() == null) {

            try {
                INSTANCE_LOCK.lock();
                if (INSTANCE.get() == null) {
                    ConnectionPoolFactory connectionPoolFactory = new ConnectionPoolFactory();
                    ConnectionPool pool = connectionPoolFactory.create();
                    INSTANCE.getAndSet(pool);
                }

            } finally {
                INSTANCE_LOCK.unlock();
            }
        }

        return INSTANCE.get();
    }

    ConnectionPool(int poolSize) {
        connectionsSemaphore = new Semaphore(poolSize);
    }

    void initializeConnections(List<ProxyConnection> connections) {
        availableConnections.addAll(connections);
    }

    public ProxyConnection getConnection() {

        try {
            connectionsSemaphore.acquire();
            LOCK.lock();

            ProxyConnection connection = availableConnections.poll();
            activeConnections.add(connection);

            return connection;

        } catch (InterruptedException e) {
            throw new ConnectionPoolException(e);

        } finally {
            LOCK.unlock();
        }
    }

    public void returnConnection(ProxyConnection connection) {

        try {
            LOCK.lock();

            if (activeConnections.contains(connection)) {
                activeConnections.remove(connection);
                availableConnections.add(connection);
                connectionsSemaphore.release();
            }
        } finally {
            LOCK.unlock();
        }
    }
}
