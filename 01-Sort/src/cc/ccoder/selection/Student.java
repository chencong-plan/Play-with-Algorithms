package cc.ccoder.selection;

/**
 * <p></p>
 *
 * @author chencong
 * @email www.ccoder.cc | cong.ccoder@gmail.com
 * @date Student.java v1.0  2020/10/8 17:53
 */
public class Student implements Comparable<Student> {

    private String name;

    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student student) {
        //重新定义Student类的排序 定义:如果分数相同则按照名字字母排序 否则按照分数高靠前
        if (this.score < student.score) {
            return -1;
        } else if (this.score > student.score) {
            return 1;
        } else {
            //this.score = student.score
            return this.name.compareTo(student.name);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
