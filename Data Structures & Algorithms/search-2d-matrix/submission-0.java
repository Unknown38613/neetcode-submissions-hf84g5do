class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0 ; i < row ; i++){
            int last = matrix[i][col - 1];
            if(target <= last){
                int left = 0, right = col - 1;
                while(left <= right){
                    int mid = left + (right - left) / 2;
                    if(matrix[i][mid] == target) return true;
                    else if(matrix[i][mid] < target) left = mid + 1;
                    else right = mid - 1;
                }
                return false;
            }
        }
        return false;
    }
}
