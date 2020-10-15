package at.fhhagenberg.sqe.stubsmocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SimpleMockTest {
    @Mock
    List<String> mockedList;

    @Test
    public void testMock() {
        Mockito.when(mockedList.get(0)).thenReturn("first");
		
        mockedList.add("first");
        assertEquals("first", mockedList.get(0));

        // verify method calls
        Mockito.verify(mockedList).get(0);
        Mockito.verify(mockedList).add("first");
    }
}