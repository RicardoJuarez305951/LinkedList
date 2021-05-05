package uaslp.ingenieria.labs.list;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ArrayListTest {

    @Test
    public void whenArrayListIsCreated_thenSizeIsZero(){
        ArrayList<Integer> list = new ArrayList<>();
        assertThat(list.getSize()).isZero();

    }
    @Test
    public void givenANewArray_WhenAddElement_thenSizeIsOne(){
        //Inicializacion
        ArrayList<Integer> list = new ArrayList<>();

        //Ejecucion
        list.add(500);

        assertThat(list.getSize()).isEqualTo(1);
        assertThat(list.get(0)).isEqualTo(500);

    }

    @Test
    public void givenAnExistenArrayWithElement_WhenAddElement_thenSizeIsTwo(){
        //Inicializacion
        ArrayList<Integer> list = new ArrayList<>();
        //Ejecucion
        list.add(500);
        list.add(100);

        assertThat(list.getSize()).isEqualTo(2);
        assertThat(list.get(0)).isEqualTo(500);
        assertThat(list.get(1)).isEqualTo(100);
    }
}
