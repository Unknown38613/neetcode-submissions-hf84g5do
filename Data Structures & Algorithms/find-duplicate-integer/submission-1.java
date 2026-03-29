class Solution {
    public int findDuplicate(int[] nums) {
        //using LinkedList Logic(Floyd’s Tortoise and Hare (Cycle Detection))
        /*n + 1 elements but only [1,n] possible values, so atleast one value
        must repeat*/
        //[1,2,3,2,2]
        int slow = nums[0]; //1
        int fast = nums[0]; //1
        do{
            slow = nums[slow]; //2 -> 3
            fast = nums[nums[fast]]; //3 -> 3
        } while(slow != fast);

        slow = nums[0]; //1

        while(slow != fast){
            slow = nums[slow]; //2
            fast = nums[fast]; //2
        }
        return slow;
    }
}
