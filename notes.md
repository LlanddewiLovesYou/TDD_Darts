Initial Tasks
- Check for a win when score is >= 170
- New score => begins at 501
- Validate throw is 1 - 20 inclusive for S, D and T
- Reset the score when score reaches 1 or less than zero
- Allow 0 when last throw is a bulls eye
- Allow 0 when last throw is a double
- Allow score of zero when final throw reaches zero and is D, T or IR
- Ensure score is reduced appropriately after a series of throws
- Reduce score to two
- Reducing score to one resets
- Handle case where the first two launches are considered passes or misses and the final one is a qualifying win (shift all non passing or missing throws to the left)
- Expect at least one throw

Order of task completion
- Check for a win when score is >= 170
- Validate throw is 1 - 20 inclusive for S, D and T