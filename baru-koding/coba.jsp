<!DOCTYPE html>
<html>
	<form action="action.php" method="post">
	<p>Your Name : <input type="text" name="name"/></p>
	<p>Your Age : <input type="text" name="age"/></p>
	<p><input type="submit"/></p>
	</form>
	
	Hi <?php echo htmlspecialchars($_POST['name']); ?>
	You are <?php echo (int)($_POST['age']); ?> years old.
	
</html>