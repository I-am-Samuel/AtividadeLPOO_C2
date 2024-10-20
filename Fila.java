import java.util.LinkedList;

public class Fila {
    private LinkedList<Castelo> fila = new LinkedList<Castelo>();

    public Fila(){
    }

    public Castelo getCastelo(int index) {
        return fila.get(index);
    }

    public void adicionar(Castelo castelo) {
        fila.addFirst(castelo);
    }

    public Castelo remover() {
        if (fila.isEmpty()) {
            return null;
        }
        return fila.removeFirst();
    }

    public Castelo top(){
        return fila.getFirst();
    }

    public int size() {
        return fila.size();
    }

    public boolean isEmpty(){
        return fila.isEmpty();
    }
}