# Push-Away Spigot Plugin

## Overview
The Push-Away plugin enhances your Minecraft server by allowing players to push others away when they are within a certain range. The plugin uses a custom wand to trigger the push action, and it comes with customizable settings to suit your server's needs. Players will be launched away from each other, creating dynamic interactions.

## Features
- **Push-Away Mechanism**: Pushes players within a specified range when triggered by right-clicking with a wand.
- **Customizable Wand**: Customize the wand's material, name, lore, and usage.
- **Cooldown**: Set a cooldown period between uses to prevent spamming the push effect.
- **Sound Effects**: Configurable sounds for both when a player is pushed and when the player pushes others away.
- **Messages**: Fully customizable messages to enhance player experience.

## Installation

1. **Download the Plugin**: 
   - Download the latest version of the plugin from the releases section.

2. **Place the Plugin in the Plugins Folder**:
   - Upload the `.jar` file to your server's `plugins` folder.

3. **Restart the Server**:
   - Restart your server for the plugin to load.

## Configuration

After installation, you can customize the plugin by editing the `config.yml` file located in the plugin’s folder.

### Configuration Options:

- **Push-Away-Range**: 
   - The maximum range (in blocks) within which players will be pushed away. (default: `3`)

- **Push-Away-Launch-X**: 
   - The force applied to the player's movement along the X-axis when pushed. (default: `0.7`)

- **Push-Away-Launch-Y**: 
   - The force applied to the player's movement along the Y-axis when pushed. (default: `0.5`)

- **Usage-Cooldown**: 
   - The time (in seconds) players must wait before they can use the push feature again. (default: `5`)

- **Wand**:
   - Customize the wand's material, name, and lore.
   - **Material**: Set the material for the wand (default: `RECORD_3`).
   - **Name**: Set the name for the wand (default: `&a&lPushAway Wand`).
   - **Lore**: Add lore to the wand (default: `"Right click to &epush &7players away!"`).

- **Sound**:
   - **On-Push**: Customize the sound played when a player pushes another.
     - **Enabled**: Whether the sound is enabled (default: `true`).
     - **Sound**: The sound that plays (default: `BLOCK_ANVIL_PLACE`).
     - **Volume**: The volume of the sound (default: `1.0`).
     - **Pitch**: The pitch of the sound (default: `1.0`).

   - **When-Pushed**: Customize the sound played when a player is pushed.
     - **Enabled**: Whether the sound is enabled (default: `true`).
     - **Sound**: The sound that plays (default: `ENTITY_BLAZE_SHOOT`).
     - **Volume**: The volume of the sound (default: `1.0`).
     - **Pitch**: The pitch of the sound (default: `1.0`).

- **Messages**: Customize the messages that players see.
   - **Permission**: Message shown when a player lacks permission to use the wand.
   - **Given-Wand**: Message shown when a player is given the PushAway Wand.
   - **Give-Other-Wand**: Message shown when a player gives the wand to someone else.
   - **Pushed-Players**: Message shown to a player when they push others away.
   - **Pushed-By-Player**: Message shown to a player when they are pushed by another.
   - **No-Players-Nearby**: Message shown when no players are within the push range.
   - **Cooldown**: Message shown when a player tries to use the wand before the cooldown expires.

### Example `config.yml`:
```yaml
Push-Away-Range: 3
Push-Away-Launch-X: 0.7
Push-Away-Launch-Y: 0.5
Usage-Cooldown: 5
Wand:
  Material: "RECORD_3"
  Name: "&a&lPushAway Wand"
  Lore:
    - "&7Right click to &epush &7players away!"
    - "&7Works up to &e%range% blocks"
Sound:
  On-Push:
    Enabled: true
    Sound: "BLOCK_ANVIL_PLACE"
    Volume: 1.0
    Pitch: 1.0
  When-Pushed:
    Enabled: true
    Sound: "ENTITY_BLAZE_SHOOT"
    Volume: 1.0
    Pitch: 1.0
Messages:
  Permission: "&cYou do not have permission to use this command!"
  Given-Wand: "&7You have been given a &a&lPushAway Wand&7!"
  Give-Other-Wand: "&7You have given &e%player% &7a &a&lPushAway Wand&7!"
  Pushed-Players: "&7You have &e&lLAUNCHED &a%num% &7players away from you!"
  Pushed-By-Player: "&7You have been &epushed away &7by &c%player%&7!"
  No-Players-Nearby: "&7There are no players nearby!"
  Cooldown: "&cYou are on cooldown for &e%time% &cmore seconds!"
