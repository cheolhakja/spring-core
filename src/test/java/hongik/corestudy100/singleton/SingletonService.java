package hongik.corestudy100.singleton;
/*
테스트 케이스가 아니고 그냥 테스트
 */
public class SingletonService {
    private static final SingletonService instance = new SingletonService() ; //final

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 패턴 테스트");
    }
}
