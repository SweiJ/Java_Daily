/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-01-11
 * Time: 10:23
 */
public class Salgrade {
    private Integer grade;
    private Double losal;
    private Double hisal;

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Double getLasal() {
        return losal;
    }

    public void setLasal(Double losal) {
        this.losal = losal;
    }

    public Double getHisal() {
        return hisal;
    }

    public void setHisal(Double hisal) {
        this.hisal = hisal;
    }

    @Override
    public String toString() {
        return "Salgrade{" +
                "grade=" + grade +
                ", lasal=" + losal +
                ", hisal=" + hisal +
                '}';
    }
}
