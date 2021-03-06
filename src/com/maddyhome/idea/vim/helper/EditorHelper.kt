/*
 * IdeaVim - Vim emulator for IDEs based on the IntelliJ platform
 * Copyright (C) 2003-2020 The IdeaVim authors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

@file:JvmName("EditorHelperRt")

package com.maddyhome.idea.vim.helper

import com.intellij.ide.scratch.ScratchFileService
import com.intellij.openapi.editor.Editor
import com.maddyhome.idea.vim.option.OptionsManager

val Editor.fileSize: Int
  get() = document.textLength

private val Editor.isDatabaseCell: Boolean
  get() = ScratchFileService.findRootType(EditorHelper.getVirtualFile(this))?.id == "consoles/.datagrid"

val Editor.isIdeaVimDisabledHere: Boolean
  get() = (isOneLineMode || isDatabaseCell) && !OptionsManager.oneline.isSet
