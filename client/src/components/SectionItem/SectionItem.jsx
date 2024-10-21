import Image from 'next/image';

export const SectionItem = ({ iconSrc, label }) => (
  <article className="group flex flex-col items-center justify-center transition-all ease-in-out hover:cursor-pointer">
    <div className="mb-2 flex size-16 items-center justify-center rounded-[20px] bg-secondary-500 group-hover:shadow-[0px_7px_18px_rgba(94,23,235,0.36)]">
      <Image src={iconSrc} width={28} height={30} alt={`${label} logo`} />
    </div>
    {label}
  </article>
);
