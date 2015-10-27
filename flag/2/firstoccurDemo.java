//��binary search�뷨����һ��������
//1.����ѭ��������һ����Ҫ��LRָ������
//2.LRָ��ֻ�����mid����Ϊmid���ܾ����Ǹ�Ԫ�أ���©��ȥ
//3.����target=a[mid]�ˣ� ��Ҫ����ѭ�������
//4.����ѭ����Ƚ�����LR�ĸ�����target��Ҫ�ȿ�L


class firstoccurDemo {


static int binary_first_occur(int a[], int size, int target) {

     int start = 0;
     int end = size - 1;
     while (start < end - 1) {
       int mid = start + (end - start)/2;
       if (target == a[mid]) {
          end = mid;
}      else if (target < a[mid]) {
          end = mid - 1;
}      else {
          start = mid + 1;
}

}

     if (target == a[start]) {
        return start;
}    if (target == a[end]) {
        return end;
}

     return -1;
}


public static void main(String[] args) {

     int a[] = {2,4,5,5,5,5,10,32};
     int size = a.length;
     int target = 10;
     int result = binary_first_occur(a, size, target);
     if (result == -1) {
        System.out.println("Not found!");
}    else {
        System.out.println("Element found! The first occurance of the element is at index: "+result);
}
}
}
