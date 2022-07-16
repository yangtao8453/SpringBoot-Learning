/**
 * @author yangtao
 * @description
 * @create 2022-07-16 10:24
 */
@SuppressWarnings("all")
public class JdkTest {
    public static void main(String[] args) {
        Integer integer = new Integer(1);
        Dto dto = new Dto();
        System.out.println(dto.getInteger() == integer.intValue());
        System.out.println(dto.getInteger() == 1);
    }
}

class Dto {
    private Integer integer;

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }
}