class Solution:
    def removeElement(self, nums, val):
        j=0
        for i in range(0,len(nums)):
            if(nums[i]!=val):
                nums[j] = nums[i]
                j=j+1
        return j
        
