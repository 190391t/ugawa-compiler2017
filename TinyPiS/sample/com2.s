	.section .data
	@ 大域変数の定義
_Pi_var_a:
	.word 0
_Pi_var_answer:
	.word 0
	.section .text
	.global _start
_start:
	@ 式をコンパイルした命令列
	ldr r0, =#100
	ldr r1, =_Pi_var_a
	str r0, [r1, #0]
	str r1, [sp, #-4]!
	str r2, [sp, #-4]!
	str r4, [sp, #-4]!
	str r5, [sp, #-4]!
	str r6, [sp, #-4]!
	str r7, [sp, #-4]!
	str r8, [sp, #-4]!
	str r9, [sp, #-4]!
	ldr r0, =_Pi_var_a
	ldr r0, [r0, #0]
	ldr r1, =buf + 16
	mov r2, #16
	mov r6, #1
	mov r8, #8
	mov r9, #0
L0:
	udiv r4, r0, r2
	mul r5, r4, r2
	sub r7, r0, r5
	cmp r7, #10
	bcs L1
	b L2
L1:
	add r7, r7, #39
L2:
	sub r1, r1, #1
	add r7, r7, #48
	strb r7, [r1]
	add r6, r6, #1
	mov r0, r4
	add r9, r9, #1
	cmp r9, r8
	bmi L0
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
	@ EXITシステムコール
	ldr r0, =_Pi_var_answer
	ldr r0, [r0, #0]
	mov r7, #1
	swi #0
.section .data
buf:
	 .space 16,0x30
.byte 0x0a
