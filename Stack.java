import java.util.ArrayList;
import java.util.List;

/**
 * Generic Stack implementation using ArrayList
 * @param <T> the type of elements in the stack
 */
public class Stack<T> {
    private List<T> elements;

    public Stack() {
        this.elements = new ArrayList<>();
    }

    /**
     * Pushes an element onto the stack
     * @param element the element to push
     */
    public void push(T element) {
        elements.add(element);
    }

    /**
     * Pops an element from the stack
     * @return the element at the top of the stack
     * @throws IllegalStateException if the stack is empty
     */
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.remove(elements.size() - 1);
    }

    /**
     * Peeks at the top element without removing it
     * @return the element at the top of the stack
     * @throws IllegalStateException if the stack is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.get(elements.size() - 1);
    }

    /**
     * Checks if the stack is empty
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * Returns the size of the stack
     * @return the number of elements in the stack
     */
    public int size() {
        return elements.size();
    }

    /**
     * Clears all elements from the stack
     */
    public void clear() {
        elements.clear();
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
