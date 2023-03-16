package Ques8;

class Example implements AutoCloseable {
    void show() {
        System.out.println("inside show");
    }
    public void close(){
        System.out.println("close from Example");
    }
}
