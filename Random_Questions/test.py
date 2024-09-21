def filter(commands: list[str]) -> list[str]:
    ans = -1
    for i, command in enumerate(commands):
        if command.startswith("C"):
            ans = i
    if ans == -1:
        return commands
    return commands[ans + 1:]

def fill_rect(image: list[list[int]], r: int, c: int, w: int, h: int, val: int):
    for i in range(r, r + h):
        for j in range(c, c + w):
            image[i][j] = val

def fill_buck(image: list[list[int]], r: int, c: int, val: int):
    for j in range(len(image[0])):
        image[r][j] = val
    for i in range(len(image)):
        image[i][c] = val

def image_edit(init: list[list[int]], commands: list[str]) -> list[list[int]]:
    cmds = filter(commands)
    for cmd in cmds:
        parts = cmd.split()
        if parts[0] == "R":
            _, r, c, w, h, val = map(int, parts)
            fill_rect(init, r, c, w, h, val)
        elif parts[0] == "B":
            _, r, c, val = map(int, parts)
            fill_buck(init, r, c, val)
    return init

# Test the program with an example
init = [
    [0, 0, 0, 0],
    [0, 0, 0, 0],
    [0, 0, 0, 0],
    [0, 0, 0, 0]
]

commands = [
    "R 1 1 3 3 255",
    "B 0 0 33"
]

expected_output = [
    [33, 33, 33, 33],
    [33, 255, 255, 255],
    [33, 255, 255, 255],
    [33, 255, 255, 255]
]

result = image_edit(init, commands)

print("Result:")
for row in result:
    print(row)

print("\nExpected:")
for row in expected_output:
    print(row)

assert result == expected_output, "The result does not match the expected output."
print("Test passed!")
