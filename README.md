# Push Near Player Spigot Plugin

## Overview
This Spigot plugin adds a unique feature to your Minecraft server, allowing players to be pushed away when they get too close to another player. The push effect is customizable and can enhance the gameplay experience by adding dynamic interactions between players.

## Features
- **Push Players Near Each Other**: Automatically pushes players when they are near another player within a configurable radius.
- **Customizable Push Settings**: Control the push force and radius to suit your server's needs.
- **Non-invasive Gameplay**: The push is smooth and doesn't interfere with player controls or activities.

## Installation
1. **Download the Plugin**: 
   - Download the latest version of the plugin from the releases section.

2. **Place the Plugin in the Plugins Folder**:
   - Upload the `.jar` file to your server's `plugins` folder.

3. **Restart the Server**:
   - Restart your server for the plugin to load.

## Configuration
Once the plugin is installed, you can configure the settings to your liking.

1. **Find the Configuration File**:
   - Navigate to the plugin's directory in your `plugins` folder.
   - Open the `config.yml` file.

2. **Adjust the Settings**:
   - **push-radius**: The radius (in blocks) within which players will be pushed when they are near another player. (default: `3`)
   - **push-force**: The force applied to players when pushed. (default: `1.0`)

Example `config.yml`:
```yaml
# Push Player Configuration

# The radius at which players will be pushed when near another player
push-radius: 3

# The force applied when a player is pushed
push-force: 1.0
