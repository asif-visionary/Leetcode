class Solution {

    // Method to find the index of the Next Smaller element to the Right (NSR)
    public int[] nextSmallerToRight(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int pseudoIndex = n;
        int[] right = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? pseudoIndex : stack.peek();
            stack.push(i);
        }
        return right;
    }

    // Method to find the index of the Next Smaller element to the Left (NSL)
    public int[] nextSmallerToLeft(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int pseudoIndex = -1;
        int[] left = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? pseudoIndex : stack.peek();
            stack.push(i);
        }
        return left;
    }

    // Method to calculate the maximum area histogram
    public int maxAreaHistogram(int[] heights) {
        int n = heights.length;
        int[] right = nextSmallerToRight(heights);
        int[] left = nextSmallerToLeft(heights);
        int[] width = new int[n];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            width[i] = right[i] - left[i] - 1;
            int area = width[i] * heights[i];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    // Main method to find the maximal rectangle area in the binary matrix
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] height = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < cols; i++) {
            height[i] = (matrix[0][i] == '1') ? 1 : 0;
        }

        maxArea = maxAreaHistogram(height);

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '0')
                    height[j] = 0;
                else
                    height[j] += 1;
            }
            maxArea = Math.max(maxArea, maxAreaHistogram(height));
        }

        return maxArea;
    }
}
