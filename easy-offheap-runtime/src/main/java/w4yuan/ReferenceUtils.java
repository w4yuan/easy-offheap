package w4yuan;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * 提供虚引用的便捷创建方式
 * ReferenceHandler里有个线程 如果虚引用引用的对象被gc掉，会将这个虚引用添加到REFERENCE_QUEUE
 * 这里自定义的线程会阻塞在获取REFERENCE_QUEUE的元素，一旦有元素入队，立即执行clean逻辑
 *
 */
public class ReferenceUtils {
	private static final ReferenceQueue<Object> REFERENCE_QUEUE = new ReferenceQueue<>();

	static {
		CustomCleanerHandler customCleanerHandler = new CustomCleanerHandler();
		customCleanerHandler.setDaemon(true);
		customCleanerHandler.setPriority(Thread.MAX_PRIORITY);
		customCleanerHandler.start();
	}

	public static ReferenceQueue<Object> getReferenceQueue() {
		return REFERENCE_QUEUE;
	}

	public static CustomCleaner create(Object o, Runnable r) {
		return CustomCleaner.create(o, REFERENCE_QUEUE, r);
	}


	private static class CustomCleanerHandler extends Thread {


		@Override
		public void run() {
			while (true) {
				Reference<?> reference = null;
				try {
					reference = REFERENCE_QUEUE.remove();
				} catch (InterruptedException e) {
					continue;
				}
				if (reference != null) {
					((CustomCleaner) reference).clean();
					reference.clear();
				}
			}
		}
	}
}
