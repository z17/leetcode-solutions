class BrowserHistory:
    home = None
    history = []
    current_position = 0

    def __init__(self, homepage: str):
        self.home = homepage
        self.history = [homepage]

    def visit(self, url: str) -> None:
        self.history = self.history[0:self.current_position+1]
        self.history.append(url)
        self.current_position = len(self.history) - 1

    def back(self, steps: int) -> str:
        self.current_position = max(0, self.current_position - steps)
        return self.history[self.current_position]

    def forward(self, steps: int) -> str:
        self.current_position = min(len(self.history) - 1, self.current_position + steps)
        return self.history[self.current_position]

obj = BrowserHistory('page 1')
obj.visit('page 2')
obj.visit('page 3')
obj.visit('page 4')
print(obj.back(2))
print(obj.forward(1))
obj.visit('page 5')
print(obj.back(1))
print(obj.forward(1))
