//Created by Nicholas Robertson for Grand Canyon University

public class MyListApplication 
{
	public static void main(String[] args)
	{	
		MyArrayList<String> list1 = new MyArrayList<>();
		MyArrayList<String> list2 = new MyArrayList<>();
				
		list1.add("Tom");
		list1.add("George");
		list1.add("Peter");
		list1.add("Jean");
		list1.add("Jane");

		list2.add("Tom");
		list2.add("George");
		list2.add("Michael");
		list2.add("Michelle");
		list2.add("Daniel");
		
		System.out.println("List 1: " + list1);
		System.out.println("List 2: " + list2);
		
		list1.addAll(list2);
		System.out.println("\r\nRunning add all method...");
		System.out.println("List 2 is adding its elements to list 1.");
		System.out.println("List 1: " + list1);
		System.out.println("List 2: " + list2);
		
		//Recreate lists (list 1 = 3, list 2 = 4)
		MyArrayList<String> list3 = new MyArrayList<>();
		MyArrayList<String> list4 = new MyArrayList<>();
				
		list3.add("Tom");
		list3.add("George");
		list3.add("Peter");
		list3.add("Jean");
		list3.add("Jane");

		list4.add("Tom");
		list4.add("George");
		list4.add("Michael");
		list4.add("Michelle");
		list4.add("Daniel");
		
		list3.removeAll(list4);
		System.out.println("\r\nRunning remove all method...");
		System.out.println("List 1 is removing any elements shared by list 2.");
		System.out.println("List 1: " + list3);
		System.out.println("List 2: " + list4);
		
		//Recreate lists (list 1 = 5, list 2 = 6)
		MyArrayList<String> list5 = new MyArrayList<>();
		MyArrayList<String> list6 = new MyArrayList<>();
				
		list5.add("Tom");
		list5.add("George");
		list5.add("Peter");
		list5.add("Jean");
		list5.add("Jane");

		list6.add("Tom");
		list6.add("George");
		list6.add("Michael");
		list6.add("Michelle");
		list6.add("Daniel");
		
		list5.retainAll(list6);
		System.out.println("\r\nRunning retain method...");
		System.out.println("List 1 is removing all elements except for those shared by list 2.");
		System.out.println("List 1: " + list5);
		System.out.println("List 2: " + list6);
		
	}
	
	public static interface MyList<E> extends java.lang.Iterable<E> {
		public void add(E e);

		/** Add a new element at the specified index in this list */
		public void add(int index, E e);

		/** Clear the list */
		public void clear();

		/** Return true if this list contains the element */
		public boolean contains(E e);

		/** Return the element from this list at the specified index */
		public E get(int index);

		/**
		 * Return the index of the first matching element in this list. Return
		 * -1 if no match.
		 */
		public int indexOf(E e);

		/** Return true if this list doesn't contain any elements */
		public boolean isEmpty();

		/**
		 * Return the index of the last matching element in this list Return -1
		 * if no match.
		 */
		public int lastIndexOf(E e);

		/**
		 * Remove the first occurrence of the element e from this list. Shift
		 * any subsequent elements to the left. Return true if the element is
		 * removed.
		 */

		public boolean remove(E e);

		/**
		 * Remove the element at the specified position in this list. Shift any
		 * subsequent elements to the left. Return the element that was removed
		 * from the list.
		 */
		public E remove(int index);

		/**
		 * Replace the element at the specified position in this list with the
		 * specified element and return the old element.
		 */
		public Object set(int index, E e);

		/** Return the number of elements in this list */
		public int size();
		
		/** Adds the elements in otherList to this list.
		* Returns true if this list changed as a result of the call */
		public boolean addAll(MyList<E> otherList);
		
		/** Removes all the elements in otherList from this list
		* Returns true if this list changed as a result of the call */
		public boolean removeAll(MyList<E> otherList);
		
		/** Retains the elements in this list that are also in otherList
		* Returns true if this list changed as a result of the call */
		public boolean retainAll(MyList<E> otherList);
	}
	
	public static abstract class MyAbstractList<E> implements MyList<E> {
		protected int size = 0; // The size of the list

		/** Create a default list */
		protected MyAbstractList() {
		}

		/** Create a list from an array of objects */
		protected MyAbstractList(E[] objects) {
			for (int i = 0; i < objects.length; i++)
				add(objects[i]);
		}

		@Override
		/** Add a new element at the end of this list */
		public void add(E e) {
			add(size, e);
		}

		@Override
		/** Return true if this list doesn't contain any elements */
		public boolean isEmpty() {
			return size == 0;
		}

		@Override
		/** Return the number of elements in this list */
		public int size() {
			return size;
		}

		@Override
		/** Remove the first occurrence of the element e
		 * from this list. Shift any subsequent elements to the left.
		 * Return true if the element is removed. */
		public boolean remove(E e) {
			if (indexOf(e) >= 0) {
				remove(indexOf(e));
				return true;
			} else
				return false;
		}
		
		@Override
		/** Adds the elements in otherList to this list.
		* Returns true if this list changed as a result of the call */
		public boolean addAll(MyList<E> otherList)
		{
			//Return false and exit method if otherList is empty
			if (otherList.size() <= 0)
			{
				return false;
			}
			
			//Add all elements from otherList to this list
			for (E e: otherList)
			{
				add(e);
			}
			
			
			return true;
		}
		
		@Override
		/** Removes all the elements in otherList from this list
		* Returns true if this list changed as a result of the call */
		public boolean removeAll(MyList<E> otherList)
		{
			//Default isRemoved to false, will only become true if an element is removed
			boolean isRemoved = false;
			int thisSize = this.size();
			int otherSize = otherList.size();
			int netSize = thisSize - otherSize;
			
			for (int i = thisSize - 1; i > netSize - 1; i--)
			{
				E e = this.get(i);
				if (otherList.contains(e))
				{
					//Remove last instance, as the elements are added at the end of the list
					remove(this.lastIndexOf(e));
					isRemoved = true;
				}
			}
			
			return isRemoved;
		}
		
		@Override
		/** Retains the elements in this list that are also in otherList
		* Returns true if this list changed as a result of the call */
		public boolean retainAll(MyList<E> otherList)
		{
			//Default isRemoved to false, will only become true if an element is removed
			boolean isRemoved = false;
			
			for (int i = this.size() - 1; i >= 0; i--)
			{
				E e = get(i);
				if (!otherList.contains(e))
				{
					remove(e);
					isRemoved = true;
				}
			}
			
			return isRemoved;
		}
	}

	public static class MyArrayList<E> extends MyAbstractList<E> {
		public static final int INITIAL_CAPACITY = 16;
		private E[] data = (E[]) new Object[INITIAL_CAPACITY];

		/** Create a default list */
		public MyArrayList() {
		}

		/** Create a list from an array of objects */
		public MyArrayList(E[] objects) {
			for (int i = 0; i < objects.length; i++)
				add(objects[i]); // Warning: don't use super(objects)!
		}

		@Override
		/** Add a new element at the specified index */
		public void add(int index, E e) {
			ensureCapacity();

			// Move the elements to the right after the specified index
			for (int i = size - 1; i >= index; i--)
				data[i + 1] = data[i];

			// Insert new element to data[index]
			data[index] = e;

			// Increase size by 1
			size++;
		}

		/** Create a new larger array, double the current size + 1 */
		private void ensureCapacity() {
			if (size >= data.length) {
				E[] newData = (E[]) (new Object[size * 2 + 1]);
				System.arraycopy(data, 0, newData, 0, size);
				data = newData;
			}
		}

		@Override
		/** Clear the list */
		public void clear() {
			data = (E[]) new Object[INITIAL_CAPACITY];
			size = 0;
		}

		@Override
		/** Return true if this list contains the element */
		public boolean contains(E e) {
			for (int i = 0; i < size; i++)
				if (e.equals(data[i]))
					return true;

			return false;
		}

		@Override
		/** Return the element at the specified index */
		public E get(int index) {
			checkIndex(index);
			return data[index];
		}

		private void checkIndex(int index) {
			if (index < 0 || index >= size)
				throw new IndexOutOfBoundsException("index " + index
						+ " out of bounds");
		}

		@Override
		/** Return the index of the first matching element
		 * in this list. Return -1 if no match. */
		public int indexOf(E e) {
			for (int i = 0; i < size; i++)
				if (e.equals(data[i]))
					return i;

			return -1;
		}

		@Override
		/** Return the index of the last matching element
		 * in this list. Return -1 if no match. */
		public int lastIndexOf(E e) {
			for (int i = size - 1; i >= 0; i--)
				if (e.equals(data[i]))
					return i;

			return -1;
		}

		@Override
		/** Remove the element at the specified position
		 * in this list. Shift any subsequent elements to the left.
		 * Return the element that was removed from the list. */
		public E remove(int index) {
			checkIndex(index);

			E e = data[index];

			// Shift data to the left
			for (int j = index; j < size - 1; j++)
				data[j] = data[j + 1];

			data[size - 1] = null; // This element is now null

			// Decrement size
			size--;

			return e;
		}

		@Override
		/** Replace the element at the specified position
		 * in this list with the specified element. */
		public E set(int index, E e) {
			checkIndex(index);
			E old = data[index];
			data[index] = e;
			return old;
		}

		@Override
		public String toString() {
			StringBuilder result = new StringBuilder("[");

			for (int i = 0; i < size; i++) {
				result.append(data[i]);
				if (i < size - 1)
					result.append(", ");
			}

			return result.toString() + "]";
		}

		/** Trims the capacity to current size */
		public void trimToSize() {
			if (size != data.length) {
				E[] newData = (E[]) (new Object[size]);
				System.arraycopy(data, 0, newData, 0, size);
				data = newData;
			} // If size == capacity, no need to trim
		}

		@Override
		/** Override iterator() defined in Iterable */
		public java.util.Iterator<E> iterator() {
			return new ArrayListIterator();
		}

		private class ArrayListIterator implements java.util.Iterator<E> {
			private int current = 0; // Current index

			@Override
			public boolean hasNext() {
				return (current < size);
			}

			@Override
			public E next() {
				return data[current++];
			}

			@Override
			public void remove() {
				MyArrayList.this.remove(current);
			}
		}
	}
	
}