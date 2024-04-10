# Specify the Java file name
file_name = "MyLinkedListTest.java"

# Open the Java file and read its content
with open(file_name, "r") as file:
    java_code = file.read()

# Replace all instances of "/" with an empty string
java_code = java_code.replace("/", "")

# Open the Java file in write mode and write the modified content back to it
with open(file_name, "w") as file:
    file.write(java_code)

print(f"All instances of '/' in {file_name} have been removed.")
