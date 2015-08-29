//给定一个整型数组，找出最大下标距离j-i，当且仅当A[i]<A[j]和i<j
int maxIndexDistance(int A[]){
    if(A == null || A.length < 2){
        return 0;        
    }
    boolean inDescSeq[] = new boolean[A.length];
    int min = A[0], n = A.length;
    inDescSeq[0] = true;
    for (int i = 0; i < n; i++){
        if (A[i] < min){
            //做下降序列的标记
            inDescSeq[i] = true;
            min = A[i];
        }
    }
    int maxDist = 0, i = n - 1, j = n - 1;
    while (i >= 0){
        if (isDescSeq[i] == false){
            i--;
            continue;
        }
        while((A[j] <= A[i]) && (j > i)){
            j--;
        }
        if ((j-i)>maxDist){
            maxDist = j - i;
        }
        i--;
    }
    return maxDist;
}