import Link from 'next/link';
import Button from '@/components/Button/Button';
import { HomeArticle } from '@/components/HomeArticle/HomeArticle';

export const HomeArticles = () => (
  <section className="mt-8 flex w-full flex-col items-center justify-center gap-y-7">
    <HomeArticle
      title="Simulación Laboral"
      description="Explora nuevas simulaciones y elige tu próximo desafío.">
      <Button
        asChild
        variant="secondary-light"
        className="min-w-16 flex-[0.5_0.5] self-end py-2 text-sm"
        size="fit">
        <Link href="/inscriptions">Inscribite</Link>
      </Button>
    </HomeArticle>
    <HomeArticle
      title="Noticias y novedades"
      description="Mantente al día con las últimas actualizaciones y oportunidades de networking.">
      <Button
        asChild
        variant="secondary-light"
        className="min-w-16 flex-[0.5_0.5] self-end py-2 text-sm"
        size="fit">
        <Link href="/">Inscribite</Link>
      </Button>
    </HomeArticle>
  </section>
);
