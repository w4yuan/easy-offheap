/*
 * CopyFrom jdk sun.misc.Cleaner
 */
package w4yuan;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 *
 * 自定义的cleaner
 * 为啥不用sun.misc.Cleaner 因为这个类在jdk高版本移动了包，会有兼容问题
 */
public class CustomCleaner extends PhantomReference<Object> {

	private static CustomCleaner first;

	private CustomCleaner next;

	private CustomCleaner prev;

	private final Runnable runnable;


	/**
	 * 实际操作为构建双向链表
	 *
	 */
	private static synchronized CustomCleaner add(CustomCleaner var0) {
		if (first != null) {
			var0.next = first;
			first.prev = var0;
		}

		first = var0;
		return var0;
	}


	/**
	 * 实际操作为将var0在链表移除，链表指针指向新的
	 *
	 *
	 *
	 */
	private static synchronized boolean remove(CustomCleaner var0) {
		if (var0.next == var0) {
			return false;
		} else {
			if (first == var0) {
				if (var0.next != null) {
					first = var0.next;
				} else {
					first = var0.prev;
				}
			}

			if (var0.next != null) {
				var0.next.prev = var0.prev;
			}

			if (var0.prev != null) {
				var0.prev.next = var0.next;
			}

			var0.next = var0;
			var0.prev = var0;
			return true;
		}
	}

	public static CustomCleaner create(Object var0, ReferenceQueue<? super Object> q, Runnable var1) {
		return var1 == null ? null : add(new CustomCleaner(var0, q, var1));
	}

	public CustomCleaner(Object referent, ReferenceQueue<? super Object> q, Runnable runnable) {
		super(referent, q);
		this.runnable = runnable;
	}

	public void clean() {
		if (remove(this)) {
			try {
				this.runnable.run();
			} catch (final Throwable var2) {
				AccessController.doPrivileged((PrivilegedAction<Void>) () -> {
					if (System.err != null) {
						(new Error("Cleaner terminated abnormally", var2)).printStackTrace();
					}
					System.exit(1);
					return null;
				});
			}
		}
	}
}
