public class LogUtils {

    // Arrumar problema de instânciar o TimeUtils e conseguir pegar o time de forma que não bugue tudo de uma vez.

    private boolean hasCreated = false;

    private void checkLog(boolean hasCreated){
        if (!hasCreated){
            this.hasCreated = true;

        }
    }

}
