# Cubit

[![Build Status](https://buildhive.cloudbees.com/job/Barteks2x/job/OpenMine/badge/icon)](https://buildhive.cloudbees.com/job/Barteks2x/job/OpenMine)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

**Cubit** is an open-source, block-based sandbox game inspired by Minecraft and Infiniminer. Built with Java and LWJGL, it provides a voxel-based 3D world where players can explore, build, and interact with procedurally generated terrain.

## 🎮 Features

- **Voxel-Based World**: Fully destructible and buildable block-based environment
- **Procedural Generation**: Dynamic terrain generation using Perlin and Value noise algorithms
- **Chunk System**: Efficient chunk-based world management with 16x16x16 and 32x32x32 chunk support
- **OpenGL Rendering**: Hardware-accelerated 3D graphics using LWJGL 2.8.5
- **Block Types**: Multiple block types including grass, dirt, stone, wood, sand, and more
- **Player Movement**: First-person perspective with collision detection
- **Performance Profiling**: Built-in GPU profiling tools for optimization

## 🛠️ Technology Stack

- **Language**: Java 1.6+
- **Graphics Library**: LWJGL (Lightweight Java Game Library) 2.8.5
- **Build Tool**: Apache Maven
- **Testing Framework**: JUnit 4.11
- **Additional Libraries**:
  - FastPNG for texture loading
  - ToxicLibs Core for mathematical operations

## 📋 Prerequisites

- **Java Development Kit (JDK)**: Version 1.6 or higher
- **Apache Maven**: Version 3.0 or higher
- **OpenGL**: Compatible graphics card with OpenGL support

## 🚀 Getting Started

### Building from Source

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Barteks2x/OpenMine.git
   cd OpenMine
   ```

2. **Build the project**:
   ```bash
   mvn clean package
   ```
   This will compile the source code, run tests, and create an executable JAR file in the `target/` directory.

3. **Run the game**:
   ```bash
   java -jar target/cubit-pre-alpha-0.0.jar
   ```

### Maven Commands

- **Compile only**: `mvn compile`
- **Run tests**: `mvn test`
- **Clean build**: `mvn clean`
- **Package JAR**: `mvn package`

## 🎯 Project Structure

```
cubit/
├── src/main/java/com/github/barteks2x/cubit/
│   ├── block/              # Block types and definitions
│   ├── location/           # Position and coordinate classes
│   ├── profiling/          # Performance profiling tools
│   ├── render/             # Rendering engine and graphics
│   │   ├── block/          # Block model builders
│   │   └── renderer/       # World and chunk renderers
│   ├── util/               # Utility classes and helpers
│   │   └── logging/        # Logging utilities
│   ├── world/              # World management
│   │   ├── chunk/          # Chunk implementations
│   │   ├── chunkloader/    # Chunk loading system
│   │   └── generator/      # Terrain generation
│   │       └── noise/      # Noise generation algorithms
│   ├── CubitMain.java      # Main entry point
│   ├── Player.java         # Player entity
│   └── PlayerController.java  # Player input handling
└── src/main/resources/
    ├── config              # Configuration file
    ├── Font256.png         # Font texture (256px)
    ├── Font512.png         # Font texture (512px)
    └── texture.png         # Block textures
```

## 🎮 Controls

*(Controls will be documented as the game develops)*

- **Movement**: WASD keys
- **Look Around**: Mouse
- **Jump**: Space
- **Place/Break Blocks**: Mouse buttons
- **Pause**: ESC

## 🔧 Configuration

Configuration settings are stored in `src/main/resources/config` and are automatically generated during the build process using Maven properties.

## 🧪 Development

### Running Tests

```bash
mvn test
```

### Code Style

This project uses NetBeans formatting conventions. The formatting configuration is available in `formatting-netbeans.zip`.

### Contributing

Contributions are welcome! Please follow these guidelines:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the **GNU General Public License v3.0** - see the [LICENCE.txt](LICENCE.txt) file for details.

## 🔗 Links

- **Source Code**: [GitHub Repository](https://github.com/Barteks2x/OpenMine)
- **Build Server**: [CloudBees BuildHive](https://buildhive.cloudbees.com/job/Barteks2x/job/OpenMine)
- **Issue Tracker**: [GitHub Issues](https://github.com/Barteks2x/OpenMine/issues)

## 📊 Project Status

**Current Version**: pre-alpha-0.0

This project is in early pre-alpha stage. Features are actively being developed and the API may change significantly between versions.

## 🙏 Acknowledgments

- Inspired by **Minecraft** (Mojang) and **Infiniminer** (Zachtronics)
- Built with **LWJGL** (Lightweight Java Game Library)
- Uses **ToxicLibs** for mathematical operations
- Terrain generation based on Perlin noise algorithms

## 📧 Contact

For questions, suggestions, or issues, please use the [GitHub Issues](https://github.com/Barteks2x/OpenMine/issues) page.

---

**Note**: This is an independent open-source project and is not affiliated with or endorsed by Mojang or Microsoft.
