package jobDesign;

import java.util.List;

public abstract class BatchPagingJob<T> extends BaseJob {


    @Override
    public void execute() {
        System.out.println("执行batchPagingJob的execute方法");
        int rounds = getRounds();
        if (rounds <= 0) {
            rounds = 1;
        }
        for(int i=0;i<rounds;i++){
            List<T> dataList = fetchList(getBatches()*i,getBatches());
            if(dataList.isEmpty()){
               return;
            }
            processList(dataList);
        }

    }

    public int getRounds() {
        int rows = getTotalAmount();
        int batches = getBatches();
        int mod = rows % batches;
        if (mod == 0) {
            return rows / batches;
        }
        return rows / batches + 1;
    }

    abstract int getTotalAmount();

    abstract List<T> fetchList(int from, int batch);

    public void process(T item) {
        System.out.println("执行batchPagingJob process");
    }

    public void processList(List<T> items) {
        if (!items.isEmpty()) {
            for (T item : items) {
                process(item);
            }
        }
    }

    public int getBatches() {
        return BATCH_AMOUNT;
    }
}
