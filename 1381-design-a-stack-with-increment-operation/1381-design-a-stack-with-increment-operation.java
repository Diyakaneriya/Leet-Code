class CustomStack {
    int[] stack;
    int size;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        size = 0;
    }

    public void push(int x) {
        if (size < stack.length) {
            stack[size++] = x;
        }
    }

    public int pop() {
        return size == 0 ? -1 : stack[--size];
    }

    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, size); i++) {
            stack[i] += val;
        }
    }
}
