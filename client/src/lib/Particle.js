export class Particle {
  x;
  y;
  size;
  speedY;
  color;

  constructor(canvas) {
    this.x = Math.random() * canvas.width;
    this.y = Math.random() * canvas.height - canvas.height;
    this.size = Math.random() * 5 + 1;
    this.speedY = Math.random() * 1 + 1;
    this.color = `hsl(${Math.random() * 360}, 100%, 50%)`;
  }

  update(canvas, isGenerating) {
    this.y += this.speedY;
    if (this.y > canvas.height) {
      if (isGenerating) {
        this.y = 0 - this.size;
        this.x = Math.random() * canvas.width;
      } else {
        return false; // Si esta fuera del viewport, se elimina
      }
    }
    return true;
  }

  draw(ctx) {
    if (ctx) {
      ctx.beginPath();
      ctx.arc(this.x, this.y, this.size, 0, Math.PI * 2);
      ctx.fillStyle = this.color;
      ctx.fill();
    }
  }
}
