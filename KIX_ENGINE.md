# Kix Engine no NewCatroid (este fork)

Branch: `feature/kix-engine`  
Motor: https://github.com/sa827472ra-bot/Kix-Engine

## Status

Branch criado a partir de `main` deste fork.  
A integração completa dos fontes Kix ainda precisa ser aplicada localmente (ou via script), porque são dezenas de arquivos Kotlin.

## Passos no seu PC

```bash
git clone https://github.com/sa827472ra-bot/NewCatroid.git
cd NewCatroid
git checkout feature/kix-engine

git clone https://github.com/sa827472ra-bot/Kix-Engine.git ../Kix-Engine
chmod +x ../Kix-Engine/integration/copy_kix_into_newcatroid.sh
../Kix-Engine/integration/copy_kix_into_newcatroid.sh .
```

Isso copia `org.catrobat.catroid.kix` para:
`catroid/src/main/java/org/catrobat/catroid/kix/`
e as cores para `catroid/src/main/res/values/kix_colors.xml`.

## Editar CategoryBricksFactory

Arquivo: `catroid/src/main/java/org/catrobat/catroid/ui/fragment/CategoryBricksFactory.kt`

1. Imports dos bricks Kix (ver `../Kix-Engine/integration/NEWCATROID.md`)
2. Método `kixBrickList()` com todos os bricks
3. No `when (category)` (ou equivalente), case da categoria Kix retornando `kixBrickList()`

## BrickCategoryListBuilder

Arquivo: `.../BrickCategoryListBuilder.kt`

Adicionar (depois de motion/looks, por exemplo):

```kotlin
categories.add(inflater.inflate(R.layout.brick_category_kix, null))
```

Layout mínimo: `catroid/src/main/res/layout/brick_category_kix.xml` (já pode ser baseado em `brick_category_motion.xml` trocando o texto para "Kix").

## XstreamSerializer

Colar aliases de:
`Kix-Engine/integration/xstream_aliases.txt`

## Stage

```kotlin
KixEngine.init(registerBricks = false)
// no frame:
KixEngine.tick(deltaMs)
```

## Build

```bash
./gradlew :catroid:assembleDebug
```

## Links

- Guia completo: https://github.com/sa827472ra-bot/Kix-Engine/blob/main/integration/NEWCATROID.md
- Este fork: https://github.com/sa827472ra-bot/NewCatroid/tree/feature/kix-engine
