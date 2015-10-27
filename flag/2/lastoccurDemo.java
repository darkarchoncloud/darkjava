//��first occurance���ƣ�ֻ��target=a[mid]��ʱ���Ϊ���ұ߼����飬
//�����������ѭ���жϵ�ʱ���ȿ�Rָ��


class lastoccurDemo {




static int binary_last_occur(int a[], int size, int target) {

    int start = 0;
    int end = size - 1;
    while (start < end - 1) {
         int mid = start + (end - start)/2;
         if (target == a[mid]) {
             start = mid;
}        else if (target < a[mid]) {
             end = mid;
}        else {
             start = mid;
}
}

    if (target == a[end]) {
        return end;
}   if (target == a[start]) {
        return start;
}

    return -1;

}

public static void main(String[] args) {


    int a[] = {4,5,5,5,5,6,10,21};
    int size = a.length;
    int target = 5;
    int result = binary_last_occur(a,size,target);
    if (result == -1) {
        System.out.println("Not found!");
}   else {
        System.out.println("Element found! The last occurance of the element is at index: "+ result);
}
}
}
