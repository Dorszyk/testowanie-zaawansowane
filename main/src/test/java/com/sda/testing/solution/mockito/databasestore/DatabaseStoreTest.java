package com.sda.testing.solution.mockito.databasestore;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DatabaseStoreTest {

    private static final String ELEMENT = "dbElement";

    @Mock(lenient = true)
    private DatabaseConnection databaseConnection;

    @InjectMocks
    private DatabaseStore databaseStore;

    @Test
    void shouldAddDataForOpenedDatabaseConnection() {
        when(databaseConnection.isOpened()).thenReturn(true);

        final int numberOfData = databaseStore.addData(ELEMENT);

        assertThat(numberOfData).isEqualTo(1);
        verify(databaseConnection).isOpened();
        verify(databaseConnection, never()).open();
    }

    @Test
    void shouldOpenDatabaseConnectionAndAddData() {
        when(databaseConnection.isOpened()).thenReturn(false, true);

        final int numberOfData = databaseStore.addData(ELEMENT);

        assertThat(numberOfData).isEqualTo(1);
        verify(databaseConnection, times(2)).isOpened();
        verify(databaseConnection).open();
        verifyNoMoreInteractions(databaseConnection);
    }

    @Test
    void shouldOpenDatabaseConnectionAndAddDataWithThenAnswer() {
        final int[] executionIndex = { 0 };
        when(databaseConnection.isOpened()).thenAnswer(invocation -> {
            if (executionIndex[0] == 0) {
                executionIndex[0]++;
                return false;
            }
            return true;
        });

        final int numberOfData = databaseStore.addData(ELEMENT);

        assertThat(numberOfData).isEqualTo(1);
        verify(databaseConnection, times(2)).isOpened();
        verify(databaseConnection).open();
        verifyNoMoreInteractions(databaseConnection);
    }
}
