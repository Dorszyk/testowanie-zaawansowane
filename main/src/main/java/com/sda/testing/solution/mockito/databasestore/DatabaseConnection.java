package com.sda.testing.solution.mockito.databasestore;

public interface DatabaseConnection {

	boolean isOpened();

	void open();

	boolean close();
}