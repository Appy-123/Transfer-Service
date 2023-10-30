package org.onedatashare.transferservice.odstransferservice.service.listner;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.stereotype.Service;

import java.util.concurrent.Semaphore;


@Service
public class ParallelismChunkListener implements ChunkListener {

    Semaphore semaphore;
    @Getter
    private int parallelism;
    Logger logger = LoggerFactory.getLogger(ParallelismChunkListener.class);

    public ParallelismChunkListener() {
        this.semaphore = new Semaphore(1);
    }

    public void changeParallelism(int nextParallelism) {
        if (nextParallelism > this.parallelism) {
            int diff = nextParallelism - this.parallelism;
            this.semaphore.release(diff);
        } else {
            int diff = this.parallelism - nextParallelism;
            try {
                this.semaphore.acquire(diff);
            } catch (InterruptedException e) {
                logger.error("Failed to acquire locks: " + diff);
            }
        }
        logger.info("Parallelism: Changed from {} to {}", this.parallelism, nextParallelism);
        this.parallelism = nextParallelism;
    }

    public void beforeChunk(ChunkContext context) {
        this.semaphore.acquireUninterruptibly();
        logger.info("Thread: {} acquired Parallel permit StepName={}", Thread.currentThread(), context.getStepContext().getStepName());


    }

    public void afterChunk(ChunkContext context) {
        this.semaphore.release();
        logger.info("Thread: {} releasing Parallel permit StepName={}", Thread.currentThread(), context.getStepContext().getStepName());
    }

    public void afterChunkError(ChunkContext context) {
    }
}