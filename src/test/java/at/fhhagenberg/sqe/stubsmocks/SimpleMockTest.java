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
    List<String> list;

    @Test
    public void testMock() {
        Mockito.when(list.size()).thenReturn(3);
        list.add("X");

        assertEquals(3, list.size());

        // verify method calls
        Mockito.verify(list).size();
        Mockito.verify(list).add("X");
    }
}