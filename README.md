# SetBlock Fix

A Fabric mod for Minecraft 1.21.1 that provides a fix for [MC-248758](https://bugs.mojang.com/browse/MC-248758) (Large Dripstone generation can trigger `setBlock` in an unloaded chunk).

## Features
- Fixes chunk generation errors, lag spikes and log spam associated with Large Dripstone placing blocks in unloaded chunks.

## Installation
1. Install [Fabric Loader](https://fabricmc.net/use/) (0.16.5 or newer).
2. Install [Fabric API](https://modrinth.com/mod/fabric-api) (0.102.0+1.21.1 minimum).
3. Drop the `setblock-fix` `.jar` file into your `mods` folder.

## Building from source
To build the mod locally:

```bash
# Windows
.\gradlew clean build

# Linux/macOS
./gradlew clean build
```
The compiled jar will be in `build/libs/`.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
