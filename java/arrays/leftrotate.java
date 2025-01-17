class leftRotate {
  public static void main(String args[]) {
      int a[] = new int[]{10, 20, 30, 40, 50, 60};
      
      // Save the first element before the rotation
      int firstElement = a[0];
      
      // Shift elements to the left by one position
      for (int i = 0; i < a.length - 1; i++) {
          a[i] = a[i + 1];
      }
      
      // Place the first element at the last position
      a[a.length - 1] = firstElement;
      
      // Print the rotated array
      for (int i = 0; i < a.length; i++) {
          System.out.print(a[i] + " ");
      }
  }
}
