class Robot:
    def __init__(self, position, health, direction, robotName):
        self.pos = position
        self.hp = health
        self.direction = direction
        self.name = robotName


def fillRobotsList(positions, healths, directions):
    RobotList = [Robot(positions[i], healths[i], directions[i], i) for i in range(len(directions))]
    RobotList.sort(key=lambda aRobot: aRobot.pos)
    return RobotList

def calculateCollisions(resultStack, bumperElement):
    while len(resultStack):
        if resultStack[-1].direction == "R":
            if resultStack[-1].hp < bumperElement.hp:
                bumperElement.hp -= 1
                resultStack.pop()
            elif resultStack[-1].hp > bumperElement.hp:
                resultStack[-1].hp -= 1
                return resultStack
            else:
                resultStack.pop()
                return resultStack
        else:
            resultStack.append(bumperElement)
            return resultStack
    return [bumperElement]


def afterCollisions(RobotList):
    resultStack = list()
    for i in range(len(RobotList)):
        if RobotList[i].direction == "R":
            resultStack.append(RobotList[i])
        else:
            resultStack = calculateCollisions(resultStack, RobotList[i])
    return resultStack




def outputBuilder(RobotList):
    RobotList.sort(key=lambda robot: robot.name)
    return [aRobot.hp for aRobot in RobotList]


class Solution:
    def survivedRobotsHealths(self, positions: List[int], healths: List[int], directions: str) -> List[int]:
        RobotList = fillRobotsList(positions, healths, directions)
        RobotList = afterCollisions(RobotList)
        return outputBuilder(RobotList)
