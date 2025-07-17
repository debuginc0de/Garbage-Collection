package com.src.garbage.Garbge_Collection;

public class DemoGarbageCollection {

    // This is our class whose objects will be collected
    static class myObject{
        private int id;

        myObject(int id){
            this.id=id;
        }

        @Override
        public String toString() {
            return "myObject{" +
                    "id=" + id +
                    '}';
        }

        @Override
        protected void finalize() throws Throwable{
           // finalize() is called by GC before object is deleted
            System.out.println("Object with id: "+ id +" is garbage collected");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        myObject obj1=new myObject(1);
        myObject obj2=new myObject(2);
        myObject obj3=new myObject(3);

        // Make two objects eligible for garbage collection
        obj1=null;
        obj2=null;
        //obj3=null;  //null

        //Suggest JVM to run Garbage Collector
        System.gc();

        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(obj3);

        System.out.println("Execution success.......");
    }
}
