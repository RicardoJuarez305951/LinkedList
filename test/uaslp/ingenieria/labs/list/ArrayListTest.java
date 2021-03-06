package uaslp.ingenieria.labs.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ArrayListTest {

    @Test
    public void whenArrayListIsCreated_thenSizeIsZero(){
        ArrayList<Integer> list = new ArrayList<>();

        int size = list.getSize();

        assertEquals(0,size);
    }

    @Test
    public void givenANewArray_whenAddElement_thenSizeIsOne(){
        ArrayList<Integer> list = new ArrayList<>();

        list.add(500);

        assertEquals(1,list.getSize());
        assertEquals(500,list.get(0));
    }

    @Test
    public void givenAnExistentArrayWithNoCapacityElement_whenAddElement_thenSizeAndCapacityIncrements(){
        ArrayList<Integer> list = new ArrayList<>();

        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        list.add(1000);

        assertEquals(5,list.getSize());
        assertEquals(500,list.get(0));
        assertEquals(600,list.get(1));
        assertEquals(700,list.get(2));
        assertEquals(800,list.get(3));
        assertEquals(1000,list.get(4));
    }

    @Test
    public void givenAListWithFiveElements_whenIterator_thenAllElementsAreAccesible(){
        ArrayList<Integer> list = new ArrayList<>();

        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);
        list.add(1000);

        Iterator<Integer> it = list.getIterator();

        assertTrue(it.hasNext());
        assertEquals(500,it.next());
        assertTrue(it.hasNext());
        assertEquals(600,it.next());
        assertTrue(it.hasNext());
        assertEquals(700,it.next());
        assertTrue(it.hasNext());
        assertEquals(800,it.next());
        assertTrue(it.hasNext());
        assertEquals(1000,it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void givenAListWithFiveElements_whenReverseIterator_thenAllElementsAreAccesible(){
        ArrayList<Integer> list = new ArrayList<>();

        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);
        list.add(1000);

        Iterator<Integer> it = list.getReverseIterator();

        assertTrue(it.hasNext());
        assertEquals(1000,it.next());
        assertTrue(it.hasNext());
        assertEquals(800,it.next());
        assertTrue(it.hasNext());
        assertEquals(700,it.next());
        assertTrue(it.hasNext());
        assertEquals(600,it.next());
        assertTrue(it.hasNext());
        assertEquals(500,it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void givenAnExistentArrayWith4Elements_whenDeleteHeadElement_thenSizeDecrements() throws MyIndexOutOfBoundsException {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        list.delete(0);

        assertEquals(3,list.getSize());
        assertEquals(600,list.get(0));
        assertEquals(700,list.get(1));
        assertEquals(800,list.get(2));
    }

    @Test
    public void givenAnExistentArrayWith4Elements_whenDeleteElementInTheMiddle_thenSizeDecrements() throws MyIndexOutOfBoundsException {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        list.delete(1);

        assertEquals(3,list.getSize());
        assertEquals(500,list.get(0));
        assertEquals(700,list.get(1));
        assertEquals(800,list.get(2));
    }

    @Test
    public void givenAnExistentArrayWith4Elements_whenDeleteTailElement_thenSizeDecrements() throws MyIndexOutOfBoundsException {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        list.delete(3);

        assertEquals(3,list.getSize());
        assertEquals(500,list.get(0));
        assertEquals(600,list.get(1));
        assertEquals(700,list.get(2));
    }

    @Test
    public void givenAnExistentArrayWith4Elements_whenDeleteElementAtIndex5_thenMyIndexOutOfBoundsExceptionIsThrown() throws MyIndexOutOfBoundsException{
        ArrayList<Integer> list = new ArrayList<>();

        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        assertThrows(MyIndexOutOfBoundsException.class, ()->list.delete(5));
    }

    @Test
    public void givenAnExistentListWith4Elements_whenGetElementAtIndex5_thenMyIndexOutOfBoundsExceptionsIsThrown(){
        ArrayList<Integer> list = new ArrayList<>();

        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);


        assertThrows(ArrayIndexOutOfBoundsException.class, ()->list.get(5));
    }

    @Test
    public void givenAnExistentListWith3Elements_WhenInsertElementAtIndex1_DataWillBeTheSame(){
        ArrayList<Integer> list = new ArrayList<>();

        list.add(500);
        list.add(600);
        list.add(700);

        Iterator<Integer> it = list.getReverseIterator();


        list.insert(1000,Position.AFTER,it);

        assertEquals(3,list.getSize());
        assertEquals(500,list.get(0));
        assertEquals(600,list.get(1));
        assertEquals(700,list.get(2));

    }
}