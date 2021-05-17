import java.util.Vector;

/**
 * @author Oscar Estrada 20565
 * Codigo de apoyo: 	https://www.geeksforgeeks.org/implement-priorityqueue-comparator-java/
 * 						https://docs.oracle.com/javase/8/docs/api/java/util/PriorityQueue.html
 *
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {

    /**
     * Se crea vector para guardar los datos 
     */
    protected Vector<E> data; // the data, kept in heap order

    public VectorHeap()
    // post: constructs a new priority queue
    {
        data = new Vector<E>();
    }

    /**
     * Constructor con nueva prioridad
     * @param v
     */
    public VectorHeap(Vector<E> v)
    {
        int i;
        data = new Vector<E>(v.size());
        for (i = 0; i < v.size(); i++) {
            add(v.get(i));
        }
    }

    /**
     * Referencia al padre
     * @param i posicion
     * @return padre del nodo
     */
    protected static int parent(int i)
    // pre: 0 <= i < size
    // post: returns parent of node at location i
    {
        return (i - 1) / 2;
    }

    /**
     * hijo a la izquierda
     * @param i posicion actual en data
     * @return posicion del hijo a la izquierda en data
     */
    protected static int left(int i)
    {
        return 2 * i + 1;
    }

    /**
     * hijo a la derecha
     * @param i posicion actual en data
     * @return posicion del hijo a la derecha en data
     */
    protected static int right(int i)
    {
        return (2 * i + 1) + 1;
    }

    /**
     * Mueve el nodo a la posicion correcta
     * @param leaf actual
     */
    protected void percolateUp(int leaf)
    {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 &&
                (value.compareTo(data.get(parent)) < 0)) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }

    /**
     * Agregar un valor al VectorHeap
     * @param value valor a agregar
     */
    public void add(E value)
    {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    /**
     * Verifica si el VectorHeap se encuentra vacio
     * @return false o true dependiendo de la condicion
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * regresa el size
     * @return Size de data
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     * limpia data
     */
    @Override
    public void clear() {
        data.clear();
    }

    /**
     * Mueve el nodo al root correcto hacia abajo
     * @param root Posicion del root a analizar
     */
    protected void pushDownRoot(int root)
    {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if ((right(root) < heapSize) &&
                        ((data.get(childpos + 1)).compareTo
                                (data.get(childpos)) < 0)) {
                    childpos++;
                }

                if ((data.get(childpos)).compareTo
                        (value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos;
                } else {
                    data.set(root, value);
                    return;
                }
            } else {
                data.set(root, value);
                return;
            }
        }
    }

    /**
     * devuelve el primer nodo
     * @return
     */
    @Override
    public E getFirst() {
        return data.get(0);
    }

    /**
     * Remueve el ultimo valor
     * @return valor
     */
    public E remove()
    {
        E minVal = getFirst();
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }
}
