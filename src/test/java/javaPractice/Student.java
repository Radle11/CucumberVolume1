//package javaPractice;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.Comparator;
//
//@Getter
//@Setter
//@AllArgsConstructor
//public class Student implements Comparator {
//    private Integer studentID;
//    private  String studentName;
//    private Boolean exam;
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "studentID=" + studentID +
//                ", studentName='" + studentName + '\'' +
//                '}';
//    }
//
//
//    @Override
//    public int compare(Student o1, Student o2) {
//        return (o1.getExam().booleanValue()==true)?-1:(o1.getExam().booleanValue()==false)?1:0;
//    }
//
//}
