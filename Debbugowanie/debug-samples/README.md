# Debug Samples

## Basics (sample1)

- Debugger view
    - Frames, Threads
    - Variables
    - Watches
    - Stepping toolbar
    - Restore view
- Breakpoint basics
    - Set breakpoint
    - View breakpoints
    - Mute breakpoints
    - Start debugger
	- Resume (F9)
- Stepping
	- Step over
	- Step into
	- Force step into
	- Show execution point
	- Step out
	- Run to cursor
- Frames
    - A frame is used to store data and partial results, as well as to perform dynamic linking, return values for methods, and dispatch exceptions. A new frame is created each time a method is invoked. A frame is destroyed when its method invocation completes
	- Drop Frame
	- Force return (getSkillString)
- Variables
    - Static variables
	- Set Value (e.g. `getSkill` method and `skillString`)
	- Evaluate expression
	    - Modify `someObjectsList` and `debugElements`	   
- Memory View
    - Show instances of `ArrayList` and `SomeObject`
    - Filtering on `this.`
	
## Frames, Threads, Breakpoints (sample2)

- Breakpoint options
	- Enabled
	- Remove once hit (pl.academy.infoshare.sample2.weapon.Weapon#getName)
	- Condition (pl.academy.infoshare.sample2.character.Character#takeWeapon => weapon.attackPower >= 50, pl.academy.infoshare.sample2.DebugApp2#main => isKilled == false|true)
	- Class Filter (pl.academy.infoshare.sample2.character.Character#Character => BadCharacter)
- Field breakpoint (pl.academy.infoshare.sample2.weapon.Weapon#attackPower)
    - Field access, field modification
- Method breakpoint (pl.academy.infoshare.sample2.weapon.Weapon#getName)
	- Frames navigation	
- Exception breakpoint
	- In Breakpoint list view add exception breakpoint (any or specified)
	- Frames navigation and drop frame to avoid throwing exception
- Watches 
    - Add watches

## Debugging Lambda Expressions (sample3 with JUnit) 

- Set breakpoint (pl.academy.infoshare.sample3.ZipFileBrowser#getMatchingEntries, pl.academy.infoshare.sample3.ZipFileBrowser#containsText)
- Step into - set line breakpoint and while debugging step into as many times as needed
- Run to cursor - set line breakpoint and while debugging run to cursor as many times as needed

## Multi threading (sample4)

- Suspend: All vs Thread
    - Set breakpoint at line 24 with condition on `i` and run with suspend all vs thread
- Threads and Frames

## Hot swapping (sample5)

- Simple hot swapping with method change
