	.section .data
	@ 大域変数の定義
	.section .text
	.global _start
_start:
	@ main関数を呼出す．戻り値は r0 に入る
	bl main
	@ EXITシステムコール
	mov r7, #1
	swi #0
main:
	@ prologue
	str r11, [sp, #-4]!
	mov r11, sp
	str r14, [sp, #-4]!
	str r1, [sp, #-4]!
	sub sp, sp, #0
	str r1, [sp, #-4]!
	str r2, [sp, #-4]!
	str r4, [sp, #-4]!
	str r5, [sp, #-4]!
	str r6, [sp, #-4]!
	str r7, [sp, #-4]!
	str r8, [sp, #-4]!
	str r9, [sp, #-4]!
	ldr r0, =#100
	ldr r1, =buf + 16
	mov r2, #16
	mov r6, #1
	mov r8, #8
	mov r9, #0
L1:
	udiv r4, r0, r2
	mul r5, r4, r2
	sub r7, r0, r5
	cmp r7, #10
	bcs L2
	b L3
L2:
	add r7, r7, #39
L3:
	sub r1, r1, #1
	add r7, r7, #48
	strb r7, [r1]
	add r6, r6, #1
	mov r0, r4
	add r9, r9, #1
	cmp r9, r8
	bmi L1
	mov r7, #4
	mov r0, #1
	mov r2, r6
	swi #0
	ldr r1, [sp], #4
	ldr r2, [sp], #4
	ldr r4, [sp], #4
	ldr r5, [sp], #4
	ldr r6, [sp], #4
	ldr r7, [sp], #4
	ldr r8, [sp], #4
	ldr r9, [sp], #4
	str r1, [sp, #-4]!
	str r2, [sp, #-4]!
	str r4, [sp, #-4]!
	str r5, [sp, #-4]!
	str r6, [sp, #-4]!
	str r7, [sp, #-4]!
	str r8, [sp, #-4]!
	str r9, [sp, #-4]!
	ldr r0, =#1
	str r1, [sp, #-4]!
	mov r1, r0
	ldr r0, =#2
	add r0, r1, r0
	ldr r1, [sp], #4
	ldr r1, =buf + 16
	mov r2, #16
	mov r6, #1
	mov r8, #8
	mov r9, #0
L4:
	udiv r4, r0, r2
	mul r5, r4, r2
	sub r7, r0, r5
	cmp r7, #10
	bcs L5
	b L6
L5:
	add r7, r7, #39
L6:
	sub r1, r1, #1
	add r7, r7, #48
	strb r7, [r1]
	add r6, r6, #1
	mov r0, r4
	add r9, r9, #1
	cmp r9, r8
	bmi L4
	mov r7, #4
	mov r0, #1
	mov r2, r6
	swi #0
	ldr r1, [sp], #4
	ldr r2, [sp], #4
	ldr r4, [sp], #4
	ldr r5, [sp], #4
	ldr r6, [sp], #4
	ldr r7, [sp], #4
	ldr r8, [sp], #4
	ldr r9, [sp], #4
	ldr r0, =#0
	b L0
	mov r0, #0
L0:
	@ prologue
	add sp, sp, #0
	ldr r1, [sp], #4
	ldr r14, [sp], #4
	ldr r11, [sp], #4
	bx r14
.section .data
buf:
	 .space 16,0x30
.byte 0x0a
