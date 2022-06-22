class QuickStart {
    public static void main (String[] args) {
        var s = new QuickStart();
        var r = s.canDivide(10, 5);
        System.out.println(r);
    }

    public boolean canDivide(int a, int b) {
        return a % b == 0;
    }
}
