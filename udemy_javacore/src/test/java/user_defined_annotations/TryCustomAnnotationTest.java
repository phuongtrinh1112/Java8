package user_defined_annotations;

//@MyAnnotation(id=134L)  can not call MyAnnotation at Class level due to configured by Target annotation
public class TryCustomAnnotationTest {

    @MyAnnotation(id = 123L)
    public void printSomeThing(){
        System.out.println("Something here!");
    }
}
