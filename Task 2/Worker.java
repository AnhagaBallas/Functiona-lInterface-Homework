public class Worker {
    private OnTaskErrorListener errorCallback;
    private OnTaskDoneListener callback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33) {
                errorCallback.onError("Error: task 33 was not done");
            } else {
                callback.onDone("Task " + i + " is done");
            }
        }
    }
}
